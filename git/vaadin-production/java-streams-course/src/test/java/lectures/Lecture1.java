package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

    List<Person> youngPeople = Lists.newArrayList();

    final int limit = 10;
    int counter = 0;

    for( Person person : people) {
      if(person.getAge() <= 18) {
        youngPeople.add(person);
        counter++;
        if(counter == limit) {
          break;
        }
      }
    }

    for (Person young : youngPeople) {
      System.out.println(young);
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
	  
	  Build b = new Build.Builder().withAge(1).withName("Abel").build();
	  System.out.println("Builder: " + b);
    ImmutableList<Person> people = MockData.getPeople();

    List<Person> youngPeople = people.stream()
        .filter(person -> person.getAge() <= 18)
        .limit(10)
        .collect(Collectors.toList());
    youngPeople.forEach(System.out::println);
    

  }
 public static class Build{
	  String name;
	  int age;
	  
	private  Build(Builder builder){
		  this.name = builder.name;
		  this.age = builder.age;
		  
	  }

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	  
@Override
	public String toString() {
		return "Build [name=" + name + ", age=" + age + "]";
	}

static class Builder{
	  String name;
	  int age;
	  Builder(String name, int age) {
		  this.name = name;
		  this.age = age;
	  }
	public Builder() {
		// TODO Auto-generated constructor stub
	}
	public Builder withName(String name) {
		this.name = name;
		return this;
	}
	public Builder withAge(int age) {
		this.age = age;
		return this;
		
	}
	Build build() {
		Build b = new Build(this);
		validate(b);
		return b;
	}
	private void validate(Build b) {
		
		if(b != null) {
			
			if(b.getName() == null | b.getAge() == 0)
				throw new IllegalArgumentException("" + null);
		}else{
			throw new IllegalArgumentException("" + b);
		}
	}
	  
  }
  
 }
}
