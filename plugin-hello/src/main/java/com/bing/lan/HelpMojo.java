package com.bing.lan;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author pc0004
 * @version 1.0
 * Create by 2022/4/13 18:42
 */
@Mojo(name = "help")
public class HelpMojo extends AbstractMojo {

  private String name;

  public void execute() throws MojoExecutionException, MojoFailureException {
    getLog().info("用来测试的插件...");
  }
}