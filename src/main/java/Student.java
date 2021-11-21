import java.io.Serializable;

/**
 * Project name(项目名称)：对象序列化控制输入输出
 * Package(包名): PACKAGE_NAME
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/21
 * Time(创建时间)： 14:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Student implements Serializable
{
    private String name;
    private int age;
    private String sex;
    private String address; //地址
    private String birthday;  //生日
    private double GPA;       //平均学分绩点

    public Student()
    {

    }

    public Student(String name, int age, String sex, String address, String birthday, double GPA)
    {
        this.name = name;
        if (age >= 0 && age <= 100)
        {
            this.age = age;
        }
        else if (age > 100)
        {
            this.age = 100;
        }
        else
        {
            this.age = 0;
        }
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        if (GPA >= 0 && GPA <= 5.0)
        {
            this.GPA = GPA;
        }
        else if (GPA > 5.0)
        {
            this.GPA = 5.0;
        }
        else
        {
            this.GPA = 0;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        if (age >= 0 && age <= 100)
        {
            this.age = age;
        }
        else if (age > 100)
        {
            this.age = 100;
        }
        else
        {
            this.age = 0;
        }
    }

    public double getGPA()
    {
        return GPA;
    }

    public void setGPA(double GPA)
    {
        if (GPA >= 0 && GPA <= 5.0)
        {
            this.GPA = GPA;
        }
        else if (GPA > 5.0)
        {
            this.GPA = 5.0;
        }
        else
        {
            this.GPA = 0;
        }
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("名字：").append(getName()).append('\n');
        stringbuilder.append("年龄：").append(getAge()).append('\n');
        stringbuilder.append("性别：").append(getSex()).append('\n');
        stringbuilder.append("地址：").append(getAddress()).append('\n');
        stringbuilder.append("出生日期：").append(getBirthday()).append('\n');
        stringbuilder.append("平均学分绩点：").append(getGPA());
        return stringbuilder.toString();
    }
}
