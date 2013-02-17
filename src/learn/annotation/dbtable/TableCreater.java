package learn.annotation.dbtable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器 生成sql语句 创建数据库表
 * 
 * @author biGpython
 * 
 */
public class TableCreater {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> cl = Class.forName("learn.annotation.dbtable.Member");
		String tableName = "";
		if (cl != null) {
			DBTable table = cl.getAnnotation(DBTable.class);
			if (table != null) {

				tableName = table.name();
				if (tableName.length() < 1) {
					tableName = cl.getName().toLowerCase();
				}

				Field[] fields = cl.getDeclaredFields();
				List<String> columnDefs = new ArrayList<String>();
				for (Field field : fields) {
					String columnName = null;
					Annotation[] anos = field.getAnnotations();
					if(anos.length < 1) continue;
					if (anos[0] instanceof SQLInteger) {
						SQLInteger sqlint = (SQLInteger) anos[0];
						columnName = sqlint.name().length() < 1 ? field
								.getName().toLowerCase() : sqlint.name();
						columnDefs.add(columnName + " INT"
								+ getConstains(sqlint.constains()));
					}
					if (anos[0] instanceof SQLString) {
						SQLString sqlstring = (SQLString) anos[0];
						columnName = sqlstring.name().length() < 1 ? field
								.getName().toLowerCase() : sqlstring.name();
						columnDefs.add(columnName + " VARCHAR("
								+ sqlstring.value() + ")"
								+ getConstains(sqlstring.constains()));

					}
					StringBuilder sb = new StringBuilder("Create table " + tableName + "(");
					for(String str : columnDefs){
						sb.append("\n " + str + ",");
					}
					String tableCreate = sb.substring(0, sb.length() - 1) + ");";
					System.out.println("Table Creation SQL for Member is: \n" + tableCreate);
				}

			}

		}

	}

	private static String getConstains(Constains constains) {
		String result = "";
		if (!constains.allowNull()) {
			result += " NOT NULL";
		}
		if (constains.primaryKey()) {
			result += " PRIMARY KEY";
		}
		if (constains.unique()) {
			result += " UNIQUE";
		}
		return result;
	}
}
