package map;

import map.TeacherMap;

import org.junit.Before;
import org.junit.Test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.*;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;
import pojo.Teacher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class GeneratorSqlmap {

  /*  //会话工厂
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void createSqlSessionFactory() throws IOException {
        // 配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

    }

    // 根据 id查询用户信息
    @Test
    public void testFindUserById() {
        // 数据库会话实例
        SqlSession sqlSession = null;
        try {
            // 创建数据库会话实例sqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 查询单个记录，根据用户id查询用户信息
            User user = sqlSession.selectOne("test.findUserById", 10);
            // 输出用户信息
            System.out.println(user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    */

    private ApplicationContext applicationContext;
        @Before
        public void setUp() throws Exception {

            applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        }

        @Test
        public void testGetUserById() throws  Exception{
            TeacherMap teacherMap = applicationContext.getBean(TeacherMap.class);
            System.out.println(teacherMap);
          List<Teacher>ts=teacherMap.findTeacherStudents(1);
          for(Teacher t:ts)
            for (Student stu:t.getStudents()) {
                System.out.println(stu.getName());
            }
        }

    public void generator() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("C:\\Users\\FF\\IdeaProjects\\SSM\\target\\classes\\generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }
    /*public static void main(String[] args) throws Exception {

        try {

            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
