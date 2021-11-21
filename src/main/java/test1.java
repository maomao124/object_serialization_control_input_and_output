import java.awt.*;
import java.io.*;

/**
 * Project name(项目名称)：对象序列化控制输入输出
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/21
 * Time(创建时间)： 14:47
 * Version(版本): 1.0
 * Description(描述)： 反序列化
 * ObjectInputStream 类继承了 InputStream 类，同时实现了 ObjectInput 接口，提供了将对象序列化并从流中读取出来的功能。该类的构造方法如下：
 * public ObjectInputStream(InputStream out)
 * 该构造方法需要传入一个 InputStream 对象，用来创建从指定 InputStream 读取的 ObjectInputStream。
 * 反序列化的步骤如下所示：
 * 1）创建一个 ObjectInputStream 输入流，这个输入流是一个处理流，所以必须建立在其他节点流的基础之上。如下代码所示。
 * // 创建一个ObjectInputStream输入流
 * ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("object. txt"));
 * 2）调用 ObjectInputStream 对象的 readObject() 方法读取流中的对象，该方法返回一个 Object 类型的 Java 对象，
 * 如果程序知道该 Java 对象的类型，则可以将该对象强制类型转换成其真实的类型。如下代码所示。
 * // 从输入流中读取一个Java对象，并将其强制类型转换为Person类
 * Person P = (Person)ois.readObject();
 * 反序列化读取的仅仅是 Java 对象的数据，而不是 Java 类，因此采用反序列化恢复 Java 对象时，
 * 必须提供该 Java 对象所属类的 class 文件，否则将会引发 ClassNotFoundException 异常。
 * 如果使用序列化机制向文件中写入了多个 Java 对象，使用反序列化机制恢复对象时必须按实际写入的顺序读取。
 * 当一个可序列化类有多个父类时（包括直接父类和间接父类），这些父类要么有无参数的构造方法，要么也是可序列化的，否
 * 则反序列化时将抛出 InvalidClassException 异常。如果父类是不可序列化的，只是带有无参数的构造方法，
 * 则该父类中定义的成员变量值不会序列化到 IO 流中。
 * Java序列化编号
 * Java 序列化机制是通过类的序列化编号（serialVersionUID）来验证版本一致性的。
 * 在反序列化时，JVM 会把传来字节流中的序列化编号和本地相应实体类的序列化编号进行比较，如果相同就认为一致，可以进行反序列化，否则会抛出 InvalidCastException 异常
 * 序列化编号有两种显式生成方式：
 * 默认的1L，比如：private static final long serialVersionUID = 1L。
 * 根据类名、接口名、成员方法及属性等来生成一个 64 位的哈希字段。
 * 当实现 Serializable 接口的对象没有显式定义一个序列化编号时，Java 序列化会根据编译的 Class 自动生成一个序列化编号，
 * 这种情况下只要 class 文件发生变化，序列化号就会改变，否则一直不变。
 */

public class test1
{
    public static void main(String[] args)
    {
        //读
        Student stu2 = null;
        Student stu3 = null;
        File file = new File("student.txt");
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        System.out.println("文件长度：" + file.length());
        try
        {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            stu2 = (Student) objectInputStream.readObject();
            stu3 = (Student) objectInputStream.readObject();
            System.out.println(stu2);
            System.out.println();
            System.out.println(stu3);
        }
        catch(FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件" + file.getName() + "不存在！！！");
            System.out.println("文件路径：" + file.getAbsolutePath());
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (objectInputStream != null)
                {
                    objectInputStream.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
