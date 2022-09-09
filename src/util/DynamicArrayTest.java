package util;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalInt;

import static org.junit.Assert.*;

public class DynamicArrayTest {

    @Test
    public void sizeIsZeroOnEmptyArray(){
        DynamicArray<Object> aDynamicArray = new DynamicArray<>(2);
        Assert.assertThat(aDynamicArray.size(), Is.is(0));
    }

    @Test
    public void addingToArrayIncreasesSize(){
        DynamicArray<Object> aDynamicArray = new DynamicArray<>(2);
        aDynamicArray.add("Item 0");
        Assert.assertThat(aDynamicArray.size(), Is.is(1));
    }

    @Test
    public void addingToArrayAddsElement(){
        DynamicArray<Object> aDynamicArray = new DynamicArray<>(2);
        aDynamicArray.add("Item 0");
        Assert.assertThat(aDynamicArray.get(0), Is.is("Item 0"));
    }

  @Test
  public void addingPastInitSizeGrowsArray(){
      DynamicArray<Object> aDynamicArray = new DynamicArray<>(2);
      aDynamicArray.add("Item 0");
      aDynamicArray.add("Item 1");
      aDynamicArray.add("Item 2");
      Assert.assertThat(aDynamicArray.size(), Is.is(3));
      Assert.assertThat(aDynamicArray.get(2), Is.is("Item 2"));
  }

  @Test
    public void canRemoveFromArray(){
      DynamicArray<Object> aDynamicArray = new DynamicArray<>(2);
      aDynamicArray.add("Item 0");
      aDynamicArray.add("Item 1");
      aDynamicArray.remove(0);
      Assert.assertThat(aDynamicArray.size(), Is.is(1));
      Assert.assertThat(aDynamicArray.get(0), Is.is("Item 1"));
  }

  @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void removingIndexOutOfBoundsGivesException(){
      DynamicArray<Object> aDynamicArray = new DynamicArray<>(2);
      aDynamicArray.add("Item 0");
      aDynamicArray.remove(10);
  }

  @Test
    public void addingtoZeroArray(){
      DynamicArray<Object> aDynamicArray = new DynamicArray<>();
      aDynamicArray.add("Item 0");
      aDynamicArray.add("Item 1");
      aDynamicArray.add("Item 2");
      Assert.assertThat(aDynamicArray.size(), Is.is(3));
      Assert.assertThat(aDynamicArray.get(2), Is.is("Item 2"));
  }

  @Test
    public void removingFromZeroArray(){
      DynamicArray<Object> aDynamicArray = new DynamicArray<>();
      aDynamicArray.add("Item 0");
      aDynamicArray.add("Item 1");
      aDynamicArray.add("Item 2");
      Assert.assertThat(aDynamicArray.remove(2), Is.is("Item 2"));
      Assert.assertThat(aDynamicArray.size(), Is.is(2));
      Assert.assertThat(aDynamicArray.get(1), Is.is("Item 1"));
  }

  @Test
    public void gettingFromZeroArray(){
      DynamicArray<Object> aDynamicArray = new DynamicArray<>();
      aDynamicArray.add("Item 0");
      aDynamicArray.add("Item 1");
      Assert.assertThat(aDynamicArray.get(1), Is.is("Item 1"));
  }


}