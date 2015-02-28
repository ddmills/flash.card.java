package flash.card.java.db;

public class DatabaseHelpers {
    public static String insert(String tableName, String[] columns, String... args) {
        String ret = "insert into " + tableName + " (`";
        
        for(String currentCol : columns) {
        	ret = ret + currentCol + "`, `";
        }
        
        ret = ret.substring(0, ret.length() - 3);
        ret = ret + ") values (\"";
        
        for (String currentArg : args) {
            ret = ret + currentArg + "\", \"";
        }
        ret = ret.substring(0, ret.length() - 3);
        ret = ret + ");";
        return ret;
    }
    
    public static String update(String tableName, String keyCol, String key, String[] columns, String... args) {
		String ret = "update " + tableName + " set `";
        int i = 0;
        for(String currentCol : columns) {
        	ret = ret + currentCol + "` = \"" + args[i++] + "\", `";
        }
        
        ret = ret.substring(0, ret.length() - 3);
        ret = ret + " where `" + keyCol + "` = \"" + key + "\"";
        
        ret = ret + ";";
        return ret;
    }
    
    public static String select(String tableName, String keyCol, String key) {
    	String ret = "select * from " + tableName + " where " + keyCol + " = \"" + key + "\"";
    	return ret;
    }
}
