class LegacyDatabase{
    public void legacyQuery(){
        System.out.println("legacy Query");
    }
}

class ConvertAdapter{
    private LegacyDatabase legacyDatabase;

    public ConvertAdapter(LegacyDatabase legacyDatabase){
        this.legacyDatabase = legacyDatabase;
    }

    public void convertQuery(){
        System.out.println("write a logic to convert query and we can call from here to legacy database");
        System.out.println("converted query");
        legacyDatabase.legacyQuery();
    }
}

class Adapter{
    public static void main(String args[]){
        LegacyDatabase legacyDatabase = new LegacyDatabase();
        ConvertAdapter adapter = new ConvertAdapter(legacyDatabase);
        adapter.convertQuery();
    }
}