package util;

public class DynamicArray <DesiredType>{

        int size;
        int i;
        DesiredType[] data;

        public DynamicArray(){
            this.size = 0;
            this.i = 0;
            this.data = (DesiredType[]) new Object[size];
        }

        public DynamicArray(int k){
            this.size = k;
            this.i = 0;
            this.data = (DesiredType[]) new Object[size];
        }

        public void add(DesiredType item){
            if (i == size){
                System.out.println("Growing");
                DesiredType[] tempData = (DesiredType[]) new Object[size + 1];
                for (int index = 0; index < size; index++){
                    tempData[index] = data[index];
                }
                size++;
                data = tempData;
            }
            data[i] = item;
            i++;
        }

        public DesiredType get(int index){
            DesiredType itemToGet = data[index];
            return (DesiredType) itemToGet.toString();
        }

        public DesiredType remove(int index){
            DesiredType itemToRemove;
            if (index == i - 1){
                itemToRemove = data[index];
                data[index] = null;
                i--;
                return itemToRemove;
            }
            itemToRemove = data[index];
            for (int find = index; find < size - 1; find++){
                data[find] = data[find + 1];
            }
            i--;
            return itemToRemove;
        }

        public int size(){
            return this.i;
        }
}
