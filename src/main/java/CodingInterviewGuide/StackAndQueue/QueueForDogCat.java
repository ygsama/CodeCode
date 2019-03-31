package CodingInterviewGuide.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**		猫狗队列 
 * 用户可以add一个猫或一只狗
 * poAll将所有动物依次弹出
 * pollDog和pollCat分别只弹出猫或者狗
 * isEmpty检查是否有猫或狗
 * isDogEmpty和isCatEmpty同理
 */
public class QueueForDogCat {

	private Queue<PetInQueue> dogQueue;
	private Queue<PetInQueue> catQueue;
	private long id ;
	
	public QueueForDogCat(){
		dogQueue = new LinkedList<PetInQueue>();
		catQueue = new LinkedList<PetInQueue>();
		id = 0;
	}
	public void add(Pet pet){
		if(pet.getType()=="Dog"){
			dogQueue.add(new PetInQueue(pet, id++));
		}else if(pet.getType()=="Cat"){
			catQueue.add(new PetInQueue(pet, id++));
		}else{
			throw new RuntimeException("error pet type");
		}
	}
	
	public Pet pollAll(){
		if(dogQueue.isEmpty()&&catQueue.isEmpty()){
			return null;
		}else if(dogQueue.isEmpty()){
			return catQueue.poll().getPet();
		}else if (catQueue.isEmpty()) {
			return dogQueue.poll().getPet();
		}else{
			if(dogQueue.peek().getId() < catQueue.peek().getId()){
				return dogQueue.poll().getPet();
			}else{
				return catQueue.poll().getPet();
			}
		}
	}
	
	public Dog pollDog(){
		if(dogQueue.isEmpty()){
			throw new RuntimeException("nothing dog");
		}else{
			return (Dog) dogQueue.poll().getPet();
		}
	}
	public Cat pollCat(){
		if(catQueue.isEmpty()){
			throw new RuntimeException("nothing cat");
		}else{
			return (Cat) catQueue.poll().getPet();
		}
	}
	public boolean isEmpty(){
		return dogQueue.isEmpty()&&catQueue.isEmpty();
	}
	public boolean isDogEmpty(){
		return dogQueue.isEmpty();
	}
	public boolean isCatEmpty(){
		return catQueue.isEmpty();
	}
	
	public class Pet{
		private String type;
		public Pet(String type){
			this.type = type;
		}
		public String getType(){
			return this.type;
		}
	}
	public class Dog extends Pet{
		public Dog(){
			super("Dog");
		}
	}
	public class Cat extends Pet{
		public Cat(){
			super("Cat");
		}
	}
	
	public class PetInQueue{
		private Pet pet;
		private long id;
		
		public PetInQueue(Pet pet, long id) {
			this.pet = pet;
			this.id = id;
		}
		public Pet getPet(){
			return this.pet;
		}
		public long getId(){
			return this.id;
		}
		public String getPetInQueueType(){
			return this.pet.getType();
		}
	}

}

