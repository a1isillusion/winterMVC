package ModelAndView;

import java.util.Map;

public class ModelAndView {
public Model model;
public View view;
public ModelAndView() {
	model=new Model();
	view=new View();
}
public void setAttribute(String key,Object value) {
	model.put(key, value);
}
public Object getAttribute(String key) {
	return model.get(key);
}
public void setViewName(String viewName) {
	view.setViewName(viewName);
}
public String getViewName() {
	return view.getViewName();
}
public void setViewType(String type) {
	view.setType(type);
}
public String getViewType() {
	return view.getType();
}
public void setNeedResolve(boolean b) {
	view.setNeedResolve(b);
}
public boolean getNeedResolve() {
	return view.getNeedResolve();
}
public Map<String,Object> getParams(){
	return model.params;
}
public void change(ModelAndView otherMav) {
	model=otherMav.model;
	view=otherMav.view;
}
}
