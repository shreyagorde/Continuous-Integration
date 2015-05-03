package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class RecipeTest extends TestCase {

	private Recipe r2;
	private RecipeBook rb;
		private CoffeeMaker cm;
		private Recipe r1,r3,r4;
		
		protected void setUp() throws Exception {
			cm = new CoffeeMaker();
			
			//Set up for r1
			r1 = new Recipe();
			r1.setName("aaa");
			r1.setAmtChocolate("5");
			r1.setAmtMilk("10");
			r1.setAmtSugar("13");
			r1.setPrice("100");
			r1.setAmtCoffee("4");
			r2 = new Recipe();
			
			r3 = new Recipe();
			r3.setName("bbb");
			r3.setAmtChocolate("5");
			r3.setAmtMilk("10");
			r3.setAmtSugar("13");
			r3.setPrice("100");
			r3.setAmtCoffee("4");
			r4 = new Recipe();
			
			r4.setName("ccc");
			r4.setAmtChocolate("50");
			r4.setAmtMilk("10");
			r4.setAmtSugar("13");
			r4.setPrice("100");
			r4.setAmtCoffee("4");
			super.setUp();
	}

	   
	public void testaddRecipe() {
		try
		{
			r2.setName("Cold Coffee");
			r2.setAmtChocolate("5");
			r2.setAmtMilk("10");
			r2.setAmtSugar("13");
			r2.setPrice("100");
			r2.setAmtCoffee("4");
			cm.addRecipe(r2);
			assertEquals(100,cm.getRecipes()[0].getPrice());
			assertNotSame(10,cm.getRecipes()[0].getPrice());
		}
		catch(RecipeException e)
		{
			fail("Recipe exception not thrown");
		}
	}
	
	
	
   public void testaddRecipeException() {
		try
		{
			r2.setName("Cold Coffee");
			r2.setAmtChocolate("-5");
			r2.setAmtMilk("10");
			r2.setAmtSugar("13");
			r2.setPrice("100");
			r2.setAmtCoffee("4");
			cm.addRecipe(r2);
			assertEquals("-5",cm.getRecipes()[0].getAmtChocolate());
			
			//fail("Recipe exception not thrown");
			
		}
		catch(RecipeException e)
		{
			
		}
	}
   public void testaddRecipeException1() {
		try
		{
			r2.setName("Cold Coffee");
			r2.setAmtChocolate("5");
			r2.setAmtMilk("aa");
			r2.setAmtSugar("13");
			r2.setPrice("100");
			r2.setAmtCoffee("4");
			cm.addRecipe(r2);
			assertEquals("-5",cm.getRecipes()[0].getAmtChocolate());
			
			//fail("Recipe exception not thrown");
			
		}
		catch(RecipeException e)
		{
			
		}
	}
   public void testaddRecipeException2() {
		try
		{
			r2.setName("Cold Coffee");
			r2.setAmtChocolate("5");
			r2.setAmtMilk("3");
			r2.setAmtSugar("aa");
			r2.setPrice("100");
			r2.setAmtCoffee("4");
			cm.addRecipe(r2);
			assertEquals("-5",cm.getRecipes()[0].getAmtChocolate());
			
			//fail("Recipe exception not thrown");
			
		}
		catch(RecipeException e)
		{
			
		}
	}
   public void testaddRecipeException3() {
		try
		{
			r2.setName("Cold Coffee");
			r2.setAmtChocolate("5");
			r2.setAmtMilk("3");
			r2.setAmtSugar("11");
			r2.setPrice("aa");
			r2.setAmtCoffee("4");
			cm.addRecipe(r2);
			assertEquals("aa",cm.getRecipes()[0].getPrice());
			
			//fail("Recipe exception not thrown");
			
		}
		catch(RecipeException e)
		{
			
		}
	}
	
	public void testeditRecipe() {
		try
		{
			cm.addRecipe(r1);
			cm.getRecipes();
			r1.setAmtChocolate("5");
			r1.setAmtMilk("10");
			r1.setAmtSugar("13");
			r1.setPrice("100");
			r1.setAmtCoffee("4");
			cm.editRecipe(0,r1);
			assertEquals("aaa",cm.editRecipe(0,r1));
			assertEquals(null,cm.editRecipe(1, r1));
				
		}
		catch(RecipeException e)
		{
			fail("Recipe exception not thrown");
		}				
		
	}
	public void testeditRecipeException() {
		try
		{
			cm.addRecipe(r3);
			cm.getRecipes();
			r3.setName("Cold Coffee");
			r3.setAmtChocolate("5");
			r3.setAmtMilk("-10");
			r3.setAmtSugar("13");
			r3.setPrice("100");
			r3.setAmtCoffee("4");
			cm.editRecipe(0,r3);
			
			fail("Recipe exception thrown");
		}
		catch(RecipeException e)
		{
			
		}
		
	}
	public void testeditRecipeException1() {
		try
		{
			cm.addRecipe(r3);
			cm.getRecipes();
			r3.setName("Cold Coffee");
			r3.setAmtChocolate("5");
			r3.setAmtMilk("10");
			r3.setAmtSugar("-13");
			r3.setPrice("100");
			r3.setAmtCoffee("4");
			cm.editRecipe(0,r3);
			
			fail("Recipe exception thrown");
		}
		catch(RecipeException e)
		{
			
		}
		
	}
	public void testeditRecipeException2() {
		try
		{
			cm.addRecipe(r3);
			cm.getRecipes();
			r3.setName("Cold Coffee");
			r3.setAmtChocolate("5");
			r3.setAmtMilk("10");
			r3.setAmtSugar("13");
			r3.setPrice("100");
			r3.setAmtCoffee("asdd");
			//cm.editRecipe(0,r3);
			assertEquals(null,cm.editRecipe(0, r3));
			//fail("Recipe exception thrown");
		}
		catch(RecipeException e)
		{
			
		}
		
	}
	public void testdeleteRecipe() {

		try{
			cm.addRecipe(r1);
			cm.addRecipe(r3);
			cm.getRecipes();
			assertEquals("bbb",cm.deleteRecipe(1));
			assertEquals("aaa",cm.deleteRecipe(0));
			assertEquals(null,cm.deleteRecipe(0));
			assertEquals(null,cm.deleteRecipe(2));
			
		}
		catch(RecipeException e)
		{
			fail("RecipeException not thrown");
		}
		
	}
	
	
	
    public void testdeleteRecipeException() {
		
		try{
			cm.addRecipe(r1);
			cm.addRecipe(r3);
			cm.getRecipes();
			assertNotSame(null,cm.deleteRecipe(0));
			
		}
		catch(RecipeException e)
		{
			
		}
		
	}
    public void testsetPriceException(){
    	try
    	{
    	r2.setPrice("-10");
    	fail();
    	}
    	catch(RecipeException e){
    		
    	}
    }
    public void testsetPrice(){
    	try
    	{
    	r2.setPrice("10");
    	assertSame(10,r2.getPrice());
    	r2.setPrice("0");
    	assertSame(0,r2.getPrice());
    	assertNotSame(10,r2.getPrice());
    	}
    	catch(RecipeException e){
    		fail();
    	}
    }
    public void testsetAmtSugarException(){
    	try
    	{
    	r2.setAmtSugar("-10");
    	fail();
    	}
    	catch(RecipeException e){
    		
    	}
    }
    public void testsetAmtSugar(){
    	try
    	{
    	r2.setAmtSugar("10");
    	assertSame(10,r2.getAmtSugar());
    	r2.setAmtSugar("0");
    	assertSame(0,r2.getAmtSugar());
    	assertNotSame(10,r2.getAmtSugar());
    	}
    	catch(RecipeException e){
    		fail();
    	}
    }
    public void testsetAmtCoffeeException(){
    	try
    	{
    	r2.setAmtCoffee("-10");
    	fail();
    	}
    	catch(RecipeException e){
    		
    	}
    }
    public void testsetAmtCoffee(){
    	try
    	{
    	r2.setAmtCoffee("10");
    	assertSame(10,r2.getAmtCoffee());
    	r2.setAmtCoffee("0");
    	assertSame(0,r2.getAmtCoffee());
    	assertNotSame(10,r2.getAmtCoffee());
    	}
    	catch(RecipeException e){
    		fail();
    	}
    }
    public void testsetAmtChocolateException(){
    	try
    	{
    	r2.setAmtChocolate("-10");
    	fail();
    	}
    	catch(RecipeException e){
    		
    	}
    }
    public void testsetAmtChocolate(){
    	try
    	{
    	r2.setAmtChocolate("10");
    	assertSame(10,r2.getAmtChocolate());
    	r2.setAmtChocolate("0");
    	assertSame(0,r2.getAmtChocolate());
    	assertNotSame(10,r2.getAmtChocolate());
    	}
    	catch(RecipeException e){
    		fail();
    	}
    }
    public void testsetAmtMilkException(){
    	try
    	{
    	r2.setAmtMilk("-10");
    	fail();
    	}
    	catch(RecipeException e){
    		
    	}
    }
    public void testsetAmtMilk(){
    	try
    	{
    	r2.setAmtMilk("10");
    	assertSame(10,r2.getAmtMilk());
    	r2.setAmtMilk("0");
    	assertSame(0,r2.getAmtMilk());
    	assertNotSame(10,r2.getAmtMilk());
    	}
    	catch(RecipeException e){
    		fail();
    	}
    }
    public void testsetName(){
    	r2.setName("recipe2");
    	assertEquals("recipe2",r2.toString());
    	assertNotSame(null,r2.toString());
    	r4=new Recipe();
    	assertEquals("",r4.toString());
    }
    
    public void testhashCode(){
    	assertNotSame(0,r1.hashCode());
    	r4=new Recipe();
    	assertEquals(31,r4.hashCode());
    }
}	
	


