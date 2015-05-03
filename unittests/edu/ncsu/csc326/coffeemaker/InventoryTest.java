package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class InventoryTest extends TestCase {
	Inventory i=new Inventory();
	Inventory i1=new Inventory();
	Recipe r1=new Recipe();
	Recipe r2,r3,r4,r5,r6,r7,r8,r11;
	CoffeeMaker cm=new CoffeeMaker();
	protected void setUp() throws Exception {
		
		
		
		
		
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("2");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		r3 = new Recipe();
		r3.setName("aaa");
		r3.setAmtChocolate("20");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("1");
		r3.setAmtSugar("1");
		r3.setPrice("75");
		
		r4 = new Recipe();
		r4.setName("aaa");
		r4.setAmtChocolate("20");
		r4.setAmtCoffee("3");
		r4.setAmtMilk("1");
		r4.setAmtSugar("27");
		r4.setPrice("75");
		
		r5 = new Recipe();
		r5.setName("aaa");
		r5.setAmtChocolate("20");
		r5.setAmtCoffee("3");
		r5.setAmtMilk("25");
		r5.setAmtSugar("1");
		r5.setPrice("75");
		
		r6 = new Recipe();
		r6.setName("aaa");
		r6.setAmtChocolate("2");
		r6.setAmtCoffee("30");
		r6.setAmtMilk("1");
		r6.setAmtSugar("1");
		r6.setPrice("75");
		
		
		
		super.setUp();
	}
	public void testenoughIngredients()
	{
		try{

			i.setChocolate(15);
			i.setCoffee(15);
			i.setMilk(15);
			i.setSugar(15);
			
			
			
			r1.setName("Coffee");
			r1.setAmtChocolate("2");
			r1.setAmtCoffee("4");
			r1.setAmtMilk("1");
			r1.setAmtSugar("1");
			r1.setPrice("50");
		//System.out.println(i.getChocolate() + "   "+r1.getAmtChocolate());
			
		cm.addRecipe(r1);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		cm.addRecipe(r5);
		cm.addRecipe(r6);
		
		assertTrue("this will succeed",i.enoughIngredients(r1));
		
		assertFalse("this will not succeed",i.enoughIngredients(r4));
		assertFalse("this will not succeed",i.enoughIngredients(r5));
		assertFalse("this will not succeed",i.enoughIngredients(r6));
		//assertFalse("this will not succeed",i.enoughIngredients(r7));
		//assertFalse("this will not succeed",i.enoughIngredients(r8));
		
		i1.setChocolate(0);
		i1.setCoffee(0);
		i1.setMilk(0);
		i1.setSugar(0);
		assertFalse("this will not succeed",i1.enoughIngredients(r3));
		
		/*i1.setChocolate(-1);
		i1.setCoffee(-2);
		i1.setMilk(-1);
		i1.setSugar(-3);
		assertFalse("this will not succeed",i1.enoughIngredients(r3));*/
		}
		catch(RecipeException e){
		}
		}

	public void testuseIngredients(){
		//The actual amount of each of ingredients in inventory is 15. Coffee in r2 is set as 3 
		r11=new Recipe();
		assertTrue("this will succeed",i.useIngredients(r2));
		assertEquals(17,i.getCoffee());
		//assertNotSame(18,i.getCoffee());
		assertFalse("this will not succeed",i.useIngredients(r3));
		//assertFalse("this will also not succeed",i.useIngredients(r11));
		
	}

	
	public void testtoString(){
		i.toString();
	}
	
	public void testaddSugar(){
		try{
		i.addSugar("5");
		
		assertEquals(20,i.getSugar());
		i.addSugar("0");
		assertEquals(20,i.getSugar());
		//i.addSugar("100");
		}
		catch(InventoryException e){
			fail("Exception should be thrown");
		}
	}
	public void testaddSugarException(){
		try{
			i.addSugar("-5");
			i.addSugar("a");
			
			assertEquals(10,i.getSugar());
			i.addSugar("3.4");
			assertEquals(13.4,i.getSugar());
		fail("Exception should be thrown");
		}
		catch(InventoryException e){
			
		}
		catch(NumberFormatException e1){
		}
	}
	public void testaddCoffee(){
		try{
		i.addCoffee("5");
		i.addCoffee("0");
		
		}
		catch(InventoryException e){
			fail("Exception should be thrown");
		}
	}
	public void testaddCoffeeException(){
		try{
		i.addCoffee("-5");
		i.addCoffee("asd");
		i.addCoffee("3.4");
		fail("Exception should be thrown");
		}
		catch(InventoryException e){
			
		}
		catch(NumberFormatException e1){
		}
	}
	public void testaddChocolate(){
		try{
		i.addChocolate("5");
		i.addChocolate("0");
		
		}
		catch(InventoryException e){
			fail("Exception should be thrown");
		}
	}
	public void testaddChocolateException(){
		try{
		i.addChocolate("-5");
		i.addChocolate("asd");
		i.addChocolate("3.4");
		
		
		fail("Exception should be thrown");
		}
		
		catch(NumberFormatException e){
		}
        catch(InventoryException e){
			
		}
	}
	public void testaddMilk(){
		try{
			System.out.println(i.getMilk());
		i.addMilk("5");
		assertEquals(19,i.getMilk());
		i.addMilk("0");
		int s=i.getMilk();System.out.print(s);
		assertEquals(19,i.getMilk());
		
		}
		catch(InventoryException e){
			fail("Exception should be thrown");
		}
	}
	public void testaddMilkException(){
		try{
		i.addMilk("-5");
		assertEquals("-5",i.getMilk());
		i.addMilk("asd");
		i.addMilk("4.4");
		fail("Exception should be thrown");
		}
		catch(InventoryException e){
			
		}
		catch(NumberFormatException e1){
		}
	}
	}




