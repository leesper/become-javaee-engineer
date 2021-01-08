# Maven

## 知识点

* maven的作用：依赖管理和项目全生命周期构建（编译、测试、打包、部署、运行）
* 仓库的概念（jar包所在位置），本地仓库、中央仓库和私服仓库
* 坐标的概念，groupId+artifactId+version
* maven的配置
* maven创建Java Web工程的后续操作（手动创建源代码目录并设置为source root）
* maven常用命令：clean compile test package install
* 使用maven进行依赖管理，依赖范围的概念（compile provided runtime test）
* maven的插件

## 练习题

1. Maven的作用及优势

Maven是Java的项目构建工具，负责管理jar包依赖和项目构建的全生命周期支持（编译、测试、打包、安装、部署），使用maven可以免去手动引入jar包和版本管理的麻烦，避免代码目录臃肿，提高开发效率。

2. Maven常用命令

* clean：清理编译生成的target目录
* compile：重新编译代码
* test：运行单元测试代码并输出测试报告
* package：打jar包
* install：将打好的jar包安装到本地目录

3. 使用Maven搭建WEB项目（完成后目录结构截图就可以）

参见javaweb_demo。