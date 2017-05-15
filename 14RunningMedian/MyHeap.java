public class MyHeap{
    MyHeapG<String> heap;
    public MyHeap(boolean x){
	heap = new MyHeapG<String>(x);
    }
    public MyHeap(){
	heap = new MyHeapG<String>();
    }
    public void add(String s){
	heap.add(s);
    }
    public String remove(){
	return heap.remove();
    }
    public String peek(){
	return heap.peek();
    }
    public static void main(String[]args){
	MyHeap heap = new MyHeap();
	for(int i = 0; i < args.length; i++){
	    heap.add(args[i]);
	}
	for(int i = 0; i < args.length; i++){
	    System.out.println(heap.remove());
	}
    }
}
