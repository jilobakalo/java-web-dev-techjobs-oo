package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
 Job object1;
 Job object2;
 Job object3;
 Job object4;
 Job object5;
 Job object6;
 @Before
    public void allObjectContainer(){
       object1  = new Job();
       object2  = new Job();
       object3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       object4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       object5 = new Job("Pizza House", new Employer("Domino's Pizza"), new Location("st.louis"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       object6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
 }

    @Test
    public void testSettingJobId(){
     int expected= object1.getId()+1;
     int actual=object2.getId();
//        assertEquals(object1.getId()+1,object2.getId());
        assertEquals(expected,actual);
    }

    @Test
    public void testJobConstructorSetsAllFields() {


        assertTrue(object3 instanceof Job);
        assertTrue(object3.getEmployer() instanceof Employer);
        assertTrue(object3.getLocation() instanceof Location);
        assertTrue(object3.getPositionType() instanceof PositionType);
        assertTrue(object3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", object3.getName());
        assertEquals("ACME", object3.getEmployer().getValue());
        assertEquals("Desert", object3.getLocation().getValue());
        assertEquals("Quality control", object3.getPositionType().getValue());
        assertEquals("Persistence", object3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
     assertFalse(object3.getId()==object4.getId());
     assertFalse(object3.equals(object4));
    }
    @Test
    public void testToStringForEachField() {
      assertEquals(object5.toString(),"\nID: " + object5.getId() +
         "\nName: " + object5.getName() +
         "\nEmployer: " + object5.getEmployer() +
         "\nLocation: " + object5.getLocation() +
         "\nPosition Type: " + object5.getPositionType() +
         "\nCore Competency: " + object5.getCoreCompetency() +
         '\n');
    }
    @Test
    public void testToStringForEmptyObject() {
     String error="OOPS! This job does not seem to exist.";
     assertEquals(error,object6.toString());
    }
    @Test
    public void checksToStringForNewLineChar() {
        assertTrue( object3.toString().startsWith("\n"));
        assertTrue( object3.toString().endsWith("\n"));
    }
    @Test
    public void checksToStringForSpaceChar() {
         assertFalse(object3.toString().startsWith(" "));
         assertFalse( object3.toString().endsWith(" "));
    }



}
