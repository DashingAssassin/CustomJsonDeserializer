package com.deserializermodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.deserializer.ModelObject1CustomDeserialzer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonAutoDetect
@JsonDeserialize(using = ModelObject1CustomDeserialzer.class)
public class ModelObject1 {

	private Integer id;
	private List<String> obj1;
	private BigDecimal obj2;
	private int obj3;
	private List<ModelObject2> modelObject2 = new ArrayList<ModelObject2>();

	public ModelObject1() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the obj1
	 */
	public List<String> getObj1() {
		return obj1;
	}

	/**
	 * @param obj1 the obj1 to set
	 */
	public void setObj1(List<String> obj1) {
		this.obj1 = obj1;
	}

	/**
	 * @return the obj2
	 */
	public BigDecimal getObj2() {
		return obj2;
	}

	/**
	 * @param obj2 the obj2 to set
	 */
	public void setObj2(BigDecimal obj2) {
		this.obj2 = obj2;
	}

	/**
	 * @return the obj3
	 */
	public int getObj3() {
		return obj3;
	}

	/**
	 * @param obj3 the obj3 to set
	 */
	public void setObj3(int obj3) {
		this.obj3 = obj3;
	}

	/**
	 * @return the modelObject2
	 */
	public List<ModelObject2> getModelObject2() {
		return modelObject2;
	}

	/**
	 * @param modelObject2 the modelObject2 to set
	 */
	public void setModelObject2(List<ModelObject2> modelObject2) {
		this.modelObject2 = modelObject2;
	}

}
