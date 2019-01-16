package ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class Model {
public Map<String, Object> params;
public Model() {
	params=new HashMap<>();
}
public void put(String key,Object value) {
	params.put(key, value);
}
public Object get(String key){
	return params.get(key);
}
}
