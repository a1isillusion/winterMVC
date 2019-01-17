package util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Type;

public class ReflectUtil {
	/** ʹ���ֽ��빤��ASM����ȡ�����Ĳ����� */
    public static String[] getMethodParamNames(final Method method) throws IOException {

        final String methodName = method.getName();
        final Class<?>[] methodParameterTypes = method.getParameterTypes();
        final int methodParameterCount = methodParameterTypes.length;
        final String className = method.getDeclaringClass().getName();
        final boolean isStatic = Modifier.isStatic(method.getModifiers());
        final String[] methodParametersNames = new String[methodParameterCount];

        ClassReader cr = new ClassReader(className);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cr.accept(new ClassAdapter(cw) {
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);

                final Type[] argTypes = Type.getArgumentTypes(desc);

                //�������Ͳ�һ��
                if (!methodName.equals(name) || !matchTypes(argTypes, methodParameterTypes)) {
                    return mv;
                }
                return new MethodAdapter(mv) {
                    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
                        //����Ǿ�̬��������һ���������Ƿ����������Ǿ�̬���������һ�������� this ,Ȼ����Ƿ����Ĳ���
                        int methodParameterIndex = isStatic ? index : index - 1;
                        if (0 <= methodParameterIndex && methodParameterIndex < methodParameterCount) {
                            methodParametersNames[methodParameterIndex] = name;
                        }
                        super.visitLocalVariable(name, desc, signature, start, end, index);
                    }
                };
            }
        }, 0);
        return methodParametersNames;
    }

    /**
     * �Ƚϲ����Ƿ�һ��
     */
    private static boolean matchTypes(Type[] types, Class<?>[] parameterTypes) {
        if (types.length != parameterTypes.length) {
            return false;
        }
        for (int i = 0; i < types.length; i++) {
            if (!Type.getType(parameterTypes[i]).equals(types[i])) {
                return false;
            }
        }
        return true;
    }
}
