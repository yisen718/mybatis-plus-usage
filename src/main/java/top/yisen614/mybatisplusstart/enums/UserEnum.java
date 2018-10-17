package top.yisen614.mybatisplusstart.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserEnum implements IEnum<Integer> {
	MALE(0, "男"),
	FEMALE(1, "女");

	private Integer value;
	private String desc;

	UserEnum(Integer value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public Integer getValue() {
		return value;
	}


	@Override
	public String toString() {
		return this.desc;
	}
}
