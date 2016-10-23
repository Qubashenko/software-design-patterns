package Iterator2;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

public class NameRepository implements Container{
    /* public String names[] = {"Robert", "John", "Julie", "Lora"};*/

    @Override
    public Iterator getIterator(){
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;
        /*
        @Override
        public boolean hasNext(){
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next(){
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
        */
        @Override
        public boolean hasNext(){
            /* simple type (un-boxed) int - not Integer
            System.out.println("Index incrementation: " +index);
            */
            if(index < NamesTypeEnum.values().length){
                return true;
            }
            return false;
        }

        @Override
        public Object next(){
            if(this.hasNext()){
                return NamesTypeEnum.values()[index++].name();
            }

            return null;
        }



    }
}
