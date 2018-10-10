package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nameOfTheCity;
	
	@OneToMany( mappedBy="city" , cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	Set<Heroes> heroes = new HashSet<Heroes>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameOfTheCity() {
		return nameOfTheCity;
	}


	public void setNameOfTheCity(String nameOfTheCity) {
		this.nameOfTheCity = nameOfTheCity;
	}


	public Set<Heroes> getHeroes() {
		return heroes;
	}


	public void setHeroes(Set<Heroes> heroes) {
		this.heroes = heroes;
	}


	public City(Long id, String nameOfTheCity, Set<Heroes> heroes) {
		super();
		this.id = id;
		this.nameOfTheCity = nameOfTheCity;
		this.heroes = heroes;
	}


	public City() {
		super();
	}
	
	public void AddHeroes(Heroes h) {
		heroes.add(h);
		h.setCity(this);
	}
	
	

}
