/**
 * @ClassName:     pythonService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author          wangxiaoyu
 * @version         V1.0  
 * @Date           2017年12月18日 下午7:25:16 
 */
package tools;
import org.python.util.PythonInterpreter;
public class PythonService {
	public PythonInterpreter interpreter;
	public PythonService(){
		interpreter = new PythonInterpreter();
		
	}
	public void doExec(String cmd){
	//	interpreter.exec("python xxx ..");
	}
}
