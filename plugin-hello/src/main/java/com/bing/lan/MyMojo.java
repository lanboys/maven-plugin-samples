package com.bing.lan;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 类与方法使用了很多 tag。注意是 tag 而不是注解，注解是直接标记的，而 tag 是在文档注释里面的
 * https://zhuanlan.zhihu.com/p/121152777
 * <p>
 * Goal which touches a timestamp file.
 *
 * @goal touch
 * @phase process-sources
 */
public class MyMojo extends AbstractMojo {

  public MyMojo() {
    System.out.println("初始化...");
  }

  /**
   * Location of the file.
   *
   * @parameter property="project.build.directory"
   * @required
   */
  private File outputDirectory;

  public void execute() throws MojoExecutionException {
    File f = outputDirectory;
    if (!f.exists()) {
      f.mkdirs();
    }
    File touch = new File(f, "touch.txt");

    FileWriter w = null;
    try {
      w = new FileWriter(touch);
      w.write("touch.txt");
    } catch (IOException e) {
      throw new MojoExecutionException("Error creating file " + touch, e);
    } finally {
      if (w != null) {
        try {
          w.close();
        } catch (IOException e) {
          // ignore
        }
      }
    }
  }
}
