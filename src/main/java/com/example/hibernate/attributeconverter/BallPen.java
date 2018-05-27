package com.example.hibernate.attributeconverter;

import java.awt.Color;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: BallPen
 * Entity to demo attribute
 * converter
 *
 */
@Entity
@Table(name = "ball_pen")

public class BallPen implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(generator = "ball_pen_id_genrator")
	@SequenceGenerator(name = "ball_pen_id_genrator", sequenceName = "ball_pen_seq_genrator")
	@Column(name = "id")
	private Long id;

	@Basic
	@Convert(converter = ColorAttributeConverter.class)
	@Column(name = "color")
	private Color color;
	
	

	public BallPen(Long id, Color color) {
		this.id = id;
		this.color = color;
	}

	public BallPen() {
	}
	
	public Long getId() {
		return id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
