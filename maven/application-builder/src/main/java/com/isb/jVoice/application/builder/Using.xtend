package com.isb.jVoice.application.builder;

import java.io.Closeable

class Using {
	
  def static <T extends Closeable, R> R using(T resource, (T) => R proc) {
    // This is kept for a case when a Throwable from close()
    // overwrites a throwable from try
    var Throwable mainThrowable = null

    try {
      return proc.apply(resource)
    } catch (Throwable t) {
      mainThrowable = t
      throw t
    } finally {
      if (mainThrowable == null) {
        resource.close
      } else {
        try {
          resource.close
        } catch (Throwable unused) {
          // ignore because mainThrowable is present
        }
      }
    }
  }
}