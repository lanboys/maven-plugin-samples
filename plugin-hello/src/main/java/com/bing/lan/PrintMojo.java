package com.bing.lan;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * 通过maven来启动程序，比较少见
 *
 * @author pc0004
 * @version 1.0
 * Create by 2022/4/14 9:54
 */
@Mojo(name = "print")
public class PrintMojo extends AbstractMojo {

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    getLog().info("定时打印程序开启....");
    // 通过maven插件来启动程序
    int count = 0;
    while (count < 5) {
      getLog().info("-------" + count + "-------");
      count++;
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    getLog().info("定时打印程序结束....");
  }
}
