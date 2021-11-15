
// Linear probing implementation of a hashtable.

// Hashing is a technique that is used to uniquely identify a specific object from a group of similar objects. 
// Suppose an object is to be assigned a key to it to make searching easy. 
//To store the key/value pair, one can use a simple array like a data structure where keys (integers) can be used directly as an index to store values. 
//However, in cases where the keys are large and cannot be used directly as an index, one should use hashing. 
//In hashing, large keys are converted into small keys by using hash functions. 
//The values are then stored in a data structure called hash table. /// Linear Probing, It may happen that the hashing technique is used to create an already used index of the array. 
//In such a case, we can search for the next empty location in the array by looking into the next cell until we find an empty cell. 
//This technique is called linear probing. 

public class HashtablePassword implements hashTableMap {
	private final int useProbe;
    private Entry[] entries;
    private final float loadFactor;
    private int size, used;         //used acquires space for NIL
    private final Entry NIL = new Entry(null, null);

	private static class Entry{
        Object key, value;
        Entry(Object k, Object v){
            key = k;    value = v;
        }
    }
    public HashtablePassword(int capacity, float loadFactor, int useProbe){
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
        this.useProbe = useProbe;
    }

	 //Complementary functions
		public int hash(Object key) {
			return (key.hashCode() & 0x7FFFFFFF) % entries.length;
		}
	

		private int nextProbe(int h, int i) {
			return (h + i) % entries.length; //Linear Probing
		}
	

    private void rehash(){
        Entry[] oldEntries = entries;
        entries = new Entry[2*entries.length+1];
        for (Entry entry : oldEntries) {
            if (entry == NIL || entry == null) continue;
            int h = hash(entry.key);
            for (int x = 0; x < entries.length; x++) {
                int j = nextProbe(h, x);
                if (entries[j] == null) {
                    entries[j] = entry;
                    break;
                }
            }
            used = size;
        }
    }
	

	// In any object-oriented programming language, Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes

	@Override
	public int add_Acc(Object Account, Object passwd) {
		if (used > (loadFactor * entries.length))
			rehash();
		int h = hash(Account);
		for (int i = 0; i < entries.length; i++) {
			int j = (h + i) % entries.length;
			Entry entry = entries[j];
			if (entry == null) {
				entries[j] = new Entry(Account, passwd);
				++size;
				++used;
				return h;
			}
			if (entry == NIL)
				continue;
			if (entry.key.equals(Account)) {
				Object oldValue = entry.value;
				entries[j].value = passwd;
				return (int) oldValue;
			}
		}
		return h;
	}
	
	 @Override
		public Object get_Acc(Object Account) {
			int h = hash(Account);
			for (int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, i);
				Entry entry = entries[j];
				if (entry == null)
					break;
				if (entry == NIL)
					continue;
				if (entry.key.equals(Account))
					return entry.value;
			}
			return null;
		}
	
		@Override
    public Object remove_Acc(Object Account){
        int h = hash(Account);
        for(int i = 0; i < entries.length; i++){
            int j = nextProbe(h,i);
            Entry entry = entries[j];
            if(entry == NIL) continue;
            if(entry.key.equals(Account)){
                Object Value = entry.value;
                entries[j] = NIL;
                size--;
                return Value;
            }
        }
        return null;
    }
}
