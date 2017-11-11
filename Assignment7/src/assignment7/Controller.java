package assignment7;

public class Controller extends Thread {
	Device device;
	Sensor heat;
	Sensor pressure;
	Controller(Device d, Sensor h, Sensor p){
		this.device =d;
		this.heat=h;
		this.pressure=p;
	}
	public void run() {
		device.startup();
		synchronized (device) {
			while(heat.getValue() <=70 && pressure.getValue() <=100) {
				System.out.println("heat -> " +heat.getValue()+", pressure ->" + pressure.getValue());
				
				try {
					device.wait();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
		device.shutdown();
		System.exit(0);
	}
}
