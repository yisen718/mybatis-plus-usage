package top.yisen614.mybatisplusstart;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.config.rules.PropertyInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中

public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(true);
        String path = "C:\\Users\\16539\\Documents\\bandou\\mybatis-plus-start\\src\\main\\java";
        gc.setOutputDir(path);
        gc.setAuthor("16539");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // dsc.setSchemaName("public");
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public PropertyInfo processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String t = fieldType.toLowerCase();
                if (t.contains("date") || t.contains("time") || t.contains("year")) {
                    switch (globalConfig.getDateType()) {
                        case ONLY_DATE:
                            return DbColumnType.DATE;
                        case SQL_PACK:
                            switch (t) {
                                case "date":
                                    return DbColumnType.DATE;
                                case "time":
                                    return DbColumnType.TIME;
                                case "year":
                                    return DbColumnType.DATE;
                                default:
                                    return DbColumnType.DATE;
                            }
                        case TIME_PACK:
                            switch (t) {
                                case "date":
                                    return DbColumnType.DATE;
                                case "time":
                                    return DbColumnType.DATE;
                                case "year":
                                    return DbColumnType.DATE;
                                default:
                                    return DbColumnType.DATE;
                            }
                    }
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        dsc.setUrl("jdbc:mysql://39.108.9.18:3306/hello?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("sen515216");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("dao");
        pc.setParent("top.yisen614.mybatisplusstart");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path + "\\top\\yisen614\\mybatisplusstart\\dao"
                        + "\\xml\\" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude("t_user", "t_article");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}