import java.util.*;
import java.lang.reflect.*;
import java_programs.*;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // .class?
        // getMethod, getDeclaredMethod, getDeclaredMethods, getMethods
        String sMethodName = args[0];
        JsonParser parser = new JsonParser();
        JsonArray input_args = parser.parse(Arrays.copyOfRange(args, 1, args.length));
	// soooo how is this read in exactly? or rather, how is Python passing this?
	// should pass it as raw json string, right?
        String sClassName = sMethodName.toUpperCase();

        try {
            Class target_class = Class.forName("java_programs."+sClassName);
            Method method = target_class.getDeclaredMethod(sMethodName);
            Type[] types = method.getGenericParameterTypes();

            Object[] obj_args = new Object[types.length];

            for (int i=0; i<types.length; i++) {
                Type type = types[i];
                obj_args[i] = gson.fromJson(input_args.get(i), (Class) type);
	    }

	    System.out.println(String.valueOf(obj_args));


	    String returnValue = String.valueOf(m.invoke(null, obj_args));
	    // If the underlying method is static, then the specified obj argument is ignored. It may be null.
	    // If the number of formal parameters required by the underlying method is 0, the supplied args array may be of length 0 or null.
	    // If the underlying method is static, the class that declared the method is initialized if it has not already been initialized.
	    // If the method completes normally, the value it returns is returned to the caller of invoke; if the value has a primitive type,
	    // it is first appropriately wrapped in an object. However, if the value has the type of an array of a primitive type, the elements
	    // of the array are not wrapped in objects; in other words, an array of primitive type is returned. If the underlying method return
	    // type is void, the invocation returns null.

	    System.out.println(returnValue);

        } catch (ClassNotFoundException e) {
            System.out.println("aww");
            //e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("nuu"+e.getCause());
        }

    }

    public static Object parser(Class type, String arg) {
        //System.out.println(String.valueOf(type));
        if (type == Object.class) {
            //System.out.println("object class..");
            // try to figure it out by looking at the first char
            // ' String, python
            // [ List
            // integer, etc
            char firstchar = arg.charAt(0);
            if (firstchar == '\'') {
                if (arg.length() == 3 && arg.charAt(2) == '\'') {
                    return arg.charAt(1);
                }
                return arg.substring(1,arg.length()-1);
            } else if ("0123456789".indexOf(firstchar) != -1) {
                if (arg.indexOf('.') != -1) {
                    return new Double(Double.parseDouble(arg));
                } else {
                return new Integer(Integer.parseInt(arg));
                }
            } else if (arg.charAt(0)=='[') {
                // list
                String[] args = arg.substring(1,arg.length()-1).split("\\s*,\\s*");
                int length = args.length;
                List to_return = new ArrayList();

                for (String current_arg : args) {
                    to_return.add(parser(Object.class,current_arg));
                }

                return to_return;
            }
        }
        if (type.equals(int.class) || type.equals(Integer.class)) {
            return new Integer(Integer.parseInt(arg));
        } else if (type.equals(String.class)) {
            return arg;
        } else if (type.equals(float.class)) {
            return new Float(Float.parseFloat(arg));
        } else if (type.equals(double.class)) {
            return new Double(Double.parseDouble(arg));
        } else if (List.class.isAssignableFrom(type)) {
            System.out.println("hit list condition");
            String[] args = arg.substring(1,arg.length()-1).split("\\s*,\\s*");
            int length = args.length;
            List to_return = new ArrayList();

            if ((Type) type instanceof ParameterizedType) {
                Type[] generic_types = ((ParameterizedType) (Type) type).getActualTypeArguments();
                System.out.println("parameter type: "+String.valueOf(generic_types));

                for (int i=0; i<length; i++) {
                    String current_arg = args[i];
                    Type current_type = generic_types[i];
                    to_return.add(parser((Class) current_type,current_arg));
                }
            } else {
                for (String current_arg : args) {
                    to_return.add(parser(Object.class,current_arg));
                }
            }

            //System.out.println(String.valueOf(to_return.get(1).getClass()));
            return to_return;
        } else if (type.isArray()) {
            System.out.println("hit array condition");
            String[] args = arg.substring(1,arg.length()-1).split("\\s*,\\s*");
            // System.out.println(String.valueOf(args));
            int length = args.length;
            Type generic_type = type.getComponentType();
            // System.out.println("component type is "+String.valueOf(generic_type));
            try {
                generic_type = loadIt(String.valueOf(generic_type));
                // System.out.println("converted type is "+String.valueOf(generic_type));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Object to_return = java.lang.reflect.Array.newInstance((Class) generic_type,length);

            // if ((Type) type instanceof ParameterizedType) {
            //     generic_type = ((ParameterizedType) (Type) type).getActualTypeArguments()[0];
            // }

            for (int i=0; i < length; i++) {
                String current_arg = args[i];
                // System.out.println("generic_type is "+String.valueOf((Class) generic_type));
                // System.out.println("current arg is "+String.valueOf((current_arg)));
                // System.out.println("parsed value is "+String.valueOf(parser((Class) generic_type, current_arg)));
                // System.out.println("parsed type is "+String.valueOf(parser((Class) generic_type, current_arg).getClass()));

                if (String.valueOf((Class) generic_type).equals("int")) {
                    // System.out.println("int condition");
                    // System.out.println(String.valueOf(type));
                    java.lang.reflect.Array.setInt(to_return, i, (int) parser((Class) generic_type,current_arg));
                } else {
                    // System.out.println("bypassing and trying to use Object");
                    Array.set(to_return, i, (Object) parser((Class) generic_type,current_arg));
                    // I have to use the right fucking set function!!!
                }

            }
            return to_return;
        } else {
            // System.out.println(String.valueOf(type));
            System.out.println("passing thru");
            return arg; // do some transformation?
        }
    }

    private static  Map<String, Class<?>> primitiveClasses = new HashMap<String, Class<?>>();

    static {
            primitiveClasses.put("byte", byte.class);
            primitiveClasses.put("short", short.class);
            primitiveClasses.put("char", char.class);
            primitiveClasses.put("int", int.class);
            primitiveClasses.put("long", long.class);
            primitiveClasses.put("float", float.class);
            primitiveClasses.put("double", double.class);
    }

    public static Class<?> loadIt(String name) throws Exception {
        if (primitiveClasses.containsKey(name)) {
            return primitiveClasses.get(name);
        } else {
            return Class.forName(name);
        }
    }
}
