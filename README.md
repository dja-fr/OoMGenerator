# Out of Memory Generator

The purpose of this app is to generate Out Of Memory Exception.
To do this a endpoint expose a method to allocate a parametrized amount of memory.

Parameters :

- memory : Integer The allocation size in MegaBytes

Example :

```
http://localhost:8080/ROOT/oom?memory=20000
```

