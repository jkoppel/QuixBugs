package junit_tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class ReadJsonUtil {

	public static JsonElement readJsonFile(String jsonName) throws IOException {
		JsonParser parser = new JsonParser();

		JsonElement je = null;
		try {
			// TODO: change the path to be more flexible
			JsonReader jr = new JsonReader(
					new FileReader("C:\\gitProjects\\quixbugs\\QuixBugs\\json_testcases\\" + jsonName + ".json"));
			jr.setLenient(true);
			je = parser.parse(jr);
			System.out.println("JsonReader:" + je.toString());
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return je;
	}

	/*
	 * Create list of objects corresponding to input arguments
	 * 
	 */

	public static Object[] getParameters(Type[] types, JsonArray args) {

		int numOfParameters = types.length;
		Object[] parameters = new Object[numOfParameters];
		Gson gsonArguments = new Gson();
		try {
			for (int i = 0; i < numOfParameters; i++) {
				Type type = types[i];
				parameters[i] = gsonArguments.fromJson(args.get(i), (Class) type);
				System.out.println("parameters" + parameters[i]);

				if (type.getTypeName().equals("java.util.ArrayList")) {
					// workaround for reading in Integers and Doubles
					// differently
					// default is to read all Numbers as Doubles
					JsonParser parser = new JsonParser();
					JsonArray array = parser.parse(args.get(i).toString()).getAsJsonArray();

					ArrayList checked_arr = new ArrayList();
					for (int j = 0; j < array.size(); j++) {
						JsonElement elem = array.get(j);
						String str_elem = elem.getAsString();
						if (str_elem.matches("[0-9]+")) {
							checked_arr.add((Integer) elem.getAsInt());
						} else if (str_elem.matches("[0-9]+.[0-9]+")) {
							checked_arr.add(elem.getAsDouble());
						} else {
							checked_arr.add(str_elem);
						}
					}
					parameters[i] = checked_arr;
				} else {
					parameters[i] = gsonArguments.fromJson(args.get(i), (Class) type);
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Incompatible types: Object cannot be converted.");
		}
		return parameters;
	}

}
