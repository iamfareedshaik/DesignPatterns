interface Connection{
    public void getConnection();
}

class Mysql implements Connection{
    public void getConnection(){
        System.out.print("mysql connection established");
    }
}

class Oracle implements Connection{
    public void getConnection(){
        System.out.print("Oracle connection established");
    }
}

interface DatabaseObj{
    public Connection create();
}

class mysqlConn implements DatabaseObj{
    public Connection create(){
        return new Mysql();
    }
}

class oracleConn implements DatabaseObj{
    public Connection create(){
        return new Oracle();
    }
}


class FactoryMethodPattern{

    public static void main(String args[]){
        DatabaseObj instance = new oracleConn();
        instance.create().getConnection();
    }
}