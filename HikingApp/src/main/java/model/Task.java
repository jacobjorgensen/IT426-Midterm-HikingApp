package model;

public class Task
{
    private String task;
    private boolean checked;

    public Task(String task, boolean checked)
    {
        this.task = task;
        this.checked = checked;
    }

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }
}


