package com.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;


public class PojoGenerator {
	public static Class<?> generate(String className, Map<String, Class<?>> properties)
			throws NotFoundException, CannotCompileException {
		
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass(className);
		
		
		cc.addInterface(resolveCtClass(Serializable.class));
		cc.addInterface(resolveCtClass(Cloneable.class));

		for (Entry<String, Class<?>> entry : properties.entrySet()) {

			cc.addField(new CtField(resolveCtClass(entry.getValue()), entry.getKey(), cc));

			cc.addMethod(generateGetter(cc, entry.getKey(), entry.getValue()));

			cc.addMethod(generateSetter(cc, entry.getKey(), entry.getValue()));
		}

		return cc.toClass();
	}

	private static CtMethod generateGetter(CtClass declaringClass, String fieldName, Class<?> fieldClass)
			throws CannotCompileException {

		String getterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

		StringBuffer sb = new StringBuffer();
		sb.append("public ").append(fieldClass.getName()).append(" ").append(getterName).append("(){")
				.append("return this.").append(fieldName).append(";").append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}

	private static CtMethod generateSetter(CtClass declaringClass, String fieldName, Class<?> fieldClass)
			throws CannotCompileException {

		String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

		StringBuffer sb = new StringBuffer();
		sb.append("public void ").append(setterName).append("(").append(fieldClass.getName()).append(" ")
				.append(fieldName).append(")").append("{").append("this.").append(fieldName).append("=")
				.append(fieldName).append(";").append("}");
		return CtMethod.make(sb.toString(), declaringClass);
	}

	public static void addAnnotation(
            CtClass clazz,
            String fieldName,
            String annotationName) throws Exception
    {
        ClassFile cfile = clazz.getClassFile();
        ConstPool cpool = cfile.getConstPool();
        CtField cfield  = clazz.getField(fieldName);
        AnnotationsAttribute attr =
                new AnnotationsAttribute(cpool, AnnotationsAttribute.visibleTag);
        Annotation annot = new Annotation(annotationName, cpool);
        attr.addAnnotation(annot);
        cfield.getFieldInfo().addAttribute(attr);
    }

	private static CtClass resolveCtClass(Class<?> clazz) throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		return pool.get(clazz.getName());
	}
}