package html.js;
 
public class HTMLSource {
	
	private String html;
	
	public String script_Alert(String msg) {
		
		html = "<script type='text/javascript'>\n";
		html += "alert('" + msg + "')\n";
		html += "</script>\n";
		
		return html;
		
	}
	
	public String script_Path(String path) {
		
		html = "<script type='text/javascript'>\n";
		html += "window.location.href='" + path + "'\n";
		html += "</script>\n";
		
		return html;
		
	}

	
}
