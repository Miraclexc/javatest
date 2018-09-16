package test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Executer implements InvocationHandler {
	public HashMap<String, Object> map = new HashMap<String, Object>();
	//Object obj = Proxy.newProxyInstance(Executer.class.getClassLoader(), new Class[] {Flyable.class}, new Executer(new Class[] {Flyable.class}, new CommonBird()));
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = this.map.get(method.getName());
		return method.invoke(obj, args);
	}
	
	public Executer(Class<?>[] classes, Object... objects) {
		for(int i=0;i<classes.length;i++) {
			for(Method method : classes[i].getMethods()) {
				String methodName = method.getName();
				if(!this.map.containsKey(methodName)) {
					this.map.put(methodName, objects[i]);
				}
			}
		}
	}
}
