package cn.itcast.properties;

import org.springframework.stereotype.Component;

@Component("abc")
public class TestValue {

	private Integer cycle = 5;

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

}
