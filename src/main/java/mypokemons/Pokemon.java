package mypokemons;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Pokemon {

  private @Id @GeneratedValue Long id;
  private String name;
  private String type1;
  private String type2;
  private int total;
  private int hp;
  private int attack;
  private int defense;
  private int spatk;
  private int spdef;
  private int speed;
  private int generation;
  private boolean legendary;

  Pokemon() {}

  Pokemon(String name, String type1, String type2, int total, int hp, int attack, int defense, int spatk, int spdef, int speed, int generation, boolean legendary) {

    this.name = name;
    this.type1 = type1;
    this.type2 = type2;
    this.total = total;
    this.hp = hp;
    this.attack = attack;
    this.defense = defense;
    this.spatk = spatk;
    this.spdef = spdef;
    this.speed = speed;
    this.generation = generation;
    this.legendary = legendary;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getType1() {
    return this.type1;
  }

  public String getType2() {
	    return this.type2;
	  }
  
  public int getTotal() {
	    return this.total;
	  }
  
  public int getHp() {
	    return this.hp;
	  }
  
  public int getAttack() {
	    return this.attack;
	  }
  
  public int getDefense() {
	    return this.defense;
	  }
  
  public int getSpatk() {
	    return this.spatk;
	  }
  
  public int getSpdef() {
	    return this.spdef;
	  }
  
  public int getSpeed() {
	    return this.speed;
	  }
  public int getGeneration() {
	    return this.generation;
	  }
  public boolean getLegendary() {
	    return this.legendary;
	  }
  
  
  
  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType1(String type1) {
    this.type1 = type1;
  }

  public void setType2(String type2) {
	    this.type2 = type2;
	  }
  
  public void setTotal(int total) {
	    this.total = total;
	  }
  
  public void setHp(int hp) {
	    this.hp = hp;
	  }
  
  public void setAttack(int attack) {
	    this.attack = attack;
	  }
  
  public void setDefense(int defense) {
	    this.defense = defense;
	  }
  
  public void setSpatk(int spatk) {
	    this.spatk = spatk;
	  }
  
  public void setSpdef(int spdef) {
	    this.spdef = spdef;
	  }
  public void setSpeed(int speed) {
	    this.speed = speed;
	  }
  public void setGeneration(int generation) {
	    this.generation = generation;
	  }
  
  public void setLegendary(boolean legendary) {
	    this.legendary = legendary;
	  }
  
  
  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Pokemon))
      return false;
    Pokemon pkmn = (Pokemon) o;
    return Objects.equals(this.id, pkmn.id) && Objects.equals(this.name, pkmn.name)
        && Objects.equals(this.type1, pkmn.type1)
        && Objects.equals(this.type2, pkmn.type2)
        && Objects.equals(this.total, pkmn.total)
        && Objects.equals(this.hp, pkmn.hp)
        && Objects.equals(this.attack, pkmn.attack)
        && Objects.equals(this.defense, pkmn.defense)
        && Objects.equals(this.spatk, pkmn.spatk)
        && Objects.equals(this.spdef, pkmn.spdef)
        && Objects.equals(this.speed, pkmn.speed)
        && Objects.equals(this.generation, pkmn.generation)
    	&& Objects.equals(this.legendary, pkmn.legendary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.type1, this.type2, this.total, this.hp, this.attack, this.defense, this.spatk, this.spdef, this.speed, this.generation, this.legendary );
  }

  @Override
  public String toString() {
    return "Pokemon{" + "id=" + this.id + ", name='" + this.name + '\'' + ", type1='" + this.type1 + '\'' + ", type2='" + this.type2 + '\'' + ", total=" + this.total + ", hp=" + this.hp + ", attack=" + this.attack + ", defense=" + this.defense + ", spatk=" + this.spatk + ", spdef=" + this.spdef + ", speed=" + this.speed + ", generation=" + this.generation + ", legendary=" + this.legendary + '}';
  }
}