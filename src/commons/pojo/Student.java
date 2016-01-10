package commons.pojo;

import java.util.List;


import javalanguage.generic.example.HtcOneSeriesManager;
import javalanguage.generic.example.HtcSeriesManager;
import javalanguage.generic.example.HtcUntitledSeriesManager;

public class Student {

	private int id;
	
	private String name;

	private List<Address> addresses;

	private HtcOneSeriesManager htcOneSeriesManager;

	private HtcUntitledSeriesManager<Long,FedoraLinux> htcUntitledSeriesManager = new HtcUntitledSeriesManager<Long,FedoraLinux>();
	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	public List<Address> getAddresses() {
		return addresses;
	}

	
	public HtcUntitledSeriesManager<Long, FedoraLinux> getHtcUntitledSeriesManager() {
		return htcUntitledSeriesManager;
	}


	public void setHtcUntitledSeriesManager(HtcUntitledSeriesManager<Long, FedoraLinux> htcUntitledSeriesManager) {
		this.htcUntitledSeriesManager = htcUntitledSeriesManager;
	}


	public <T extends Object> T gm() {
		final int et = 5;
		return null;
	}
	
}
