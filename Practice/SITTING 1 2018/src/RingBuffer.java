
public class RingBuffer extends Buffer{
	private int start, end, elementCount;
	
	public RingBuffer(int capacity) {
		super(capacity);
		this.start = 0;
		this.end = 0;
		this.elementCount = 0;
	}
	
	public RingBuffer() {
		super(10);
		this.start = 0;
		this.end = 0;
		this.elementCount = 0;
	}
	
	public boolean isFull() {
		if (elementCount == buffer.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if (elementCount == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void clear() {
		super.clear();
		this.start = 0;
		this.end = 0;
		this.elementCount = 0;
	}
	
	public void addToBuffer(int add) {
		if (isFull()) {
			System.out.println("Buffer is full.\n");
		}
		else {
			buffer[this.end+1] = add;
			if ((this.end == this.start) && (isEmpty())) {
				this.start = this.end+1;
			}
			this.end ++;
			this.elementCount ++;
			if (this.end == buffer.length) {
				this.end = 0;
			}
		}
	}
	
	public int getFromBuffer() {
		if (isEmpty()) {
			System.out.println("Buffer is empty.\n");
			return -1;
		}
		else {
			int result = buffer[this.start];
			buffer[this.start] = -1;
			this.start++;
			this.elementCount --;
			return result;
		}
	}
	
	public static void main(String[] args) {
		RingBuffer theBuffer = new RingBuffer();
		System.out.println(theBuffer.isEmpty());
		theBuffer.addToBuffer(78);
		System.out.println(theBuffer.isEmpty());
		System.out.println(theBuffer.isFull());
		System.out.println(theBuffer.getFromBuffer());
		System.out.println(theBuffer.isEmpty());
		System.out.println(theBuffer.isFull());
		theBuffer.addToBuffer(98);
		theBuffer.addToBuffer(9);
		theBuffer.addToBuffer(0);
		System.out.println(theBuffer.getFromBuffer());
		System.out.println(theBuffer.getFromBuffer());
		System.out.println(theBuffer.getFromBuffer());

	}
}
