import java.awt.*;
import java.io.*;

/**
 * Project name(项目名称)：对象序列化控制输入输出
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/21
 * Time(创建时间)： 14:12
 * Version(版本): 1.0
 * Description(描述)： 对象序列化（Serialize）指将一个 Java 对象写入 IO 流中，与此对应的是，
 * 对象的反序列化（Deserialize）则指从 IO 流中恢复该 Java 对象。如果想让某个 Java 对象能够序列化，
 * 则必须让它的类实现 java.io.Serializable 接口，接口定义如下：
 * public interface Serializable {
 * }
 * Serializable 接口是一个空接口，实现该接口无须实现任何方法，它只是告诉 JVM 该类可以被序列化机制处理。
 * 通常建议程序创建的每个 JavaBean 类都实现 Serializable。
 * ObjectInput 接口与 ObjectOutput 接口分别继承了 DataInput 和 DataOutput  接口，主要提供用于读写基本数据和对象数据的方法。
 * ObjectInput 接口提供了 readObject() 方法，此方法用于将对象从流中读出。ObjectOutput 提供了 writeObject() 方法，此方法用于将对象写入流中。
 * 因为 ObjectInput 与 ObjectOutput 都是接口，所以不能创建对象，只能使用分别实现了这两个接口的 ObjectInputStream 类和 ObjectOutputStream 类来创建对象。
 * 下面讲解如何使用 ObjectInputStream 类和 ObjectOutputStream 类来操作数据。
 * ObjectOutputStream 类继承了 OutputStream 类，同时实现了 ObjectOutput 接口，提供将对象序列化并写入流中的功能，该类的构造方法如下：
 * public ObjectOutputStream (OutputStream out)
 * 该构造方法需要传入一个 OutputStream 对象，用来表示将对象二进制流写入到指定的 OutputStream 中。
 * 程序通过以下两个步骤来序列化对象：
 * 1）创建一个 ObjectOutputStream 对象，如下代码所示。
 * // 创建个 ObjectOutputStream 输出流
 * ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
 * 2）调用 ObjectOutputStream 对象的 writeObject() 方法输出可序列化对象，如下代码所示。
 * // 将一个 Person 对象输出到输出流中
 * oos.writerObject(per);
 */

public class test
{
    public static void main(String[] args)
    {
        Student stu = new Student("张三", 18, "男", "北京", "2001-05-09", 3.14);
        Student stu1 = new Student();
        stu1.setName("李四");
        stu1.setAge(19);
        stu1.setSex("男");
        stu1.setAddress("上海");
        stu1.setBirthday("2002-07-22");
        stu1.setGPA(3.98);
        System.out.println(stu);
        System.out.println();
        System.out.println(stu1);
        File file = new File("student.txt");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stu);
            objectOutputStream.writeObject(stu1);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("文件未找到！！！");
            Toolkit.getDefaultToolkit().beep();
        }
        catch (NotSerializableException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("对象未序列化:" + e.getMessage());
            System.err.println(e.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null)
                {
                    objectOutputStream.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("写入完成");
        System.out.println("文件长度：" + file.length());
        System.out.println();
        System.out.println("读：");
        test1.main(null);
    }
}
