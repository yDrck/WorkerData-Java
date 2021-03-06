package contracts;

import usr.Worker;
import java.util.Date;

public class MainContract {
	
	Worker worker;
	private Date data;
	private double valueHour;
	private double duration;
	
	
	public MainContract(Date data, double valueHour, double duration) {
		this.data = data;
		this.valueHour = valueHour;
		this.duration = duration;
	}


	public MainContract() {
	}


	public Date getDate() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public double getValueHour() {
		return valueHour;
	}


	public void setValueHour(double valueHour) {
		this.valueHour = valueHour;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getTotalValue() {
		return this.getValueHour() * this.getDuration();
	}


}
