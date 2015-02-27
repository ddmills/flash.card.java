package flash.card.java.db;

public class DatabaseHelpers {
    public static String insert(String tableName, String... args)
    {
        String ret = "insert into " + tableName + " values ('";
        
        for(String currentArg : args) {
            ret = ret + currentArg + "', '";
        }
        ret = ret.substring(0, ret.length() - 3);
        ret = ret + ");";
        return ret;
    }
    
    public String update() {
        return null;
    }
}
