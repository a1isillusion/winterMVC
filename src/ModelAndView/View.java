package ModelAndView;

public class View {
	public String viewName;
	public String type = "forward";
	public boolean needResolve = true;

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getNeedResolve() {
		return needResolve;
	}

	public void setNeedResolve(boolean needResolve) {
		this.needResolve = needResolve;
	}
}
