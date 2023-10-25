package ru.netology.HW12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotSeach() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("помыть");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSeach2Different() {
        SimpleTask simpleTask = new SimpleTask(5, "Звонок родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Звонок по видео",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Звонок");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSeachOne() {
        SimpleTask simpleTask = new SimpleTask(5, "Звонок родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Звонок по видео",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    //SIMPLETASK
    @Test
    public void shouldSeachByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        ToDos todos = new ToDos();
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSeachByGettingTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        ToDos todos = new ToDos();
        todos.add(simpleTask);

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNoSeachSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        ToDos todos = new ToDos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("Оплатить счета");
        Assertions.assertArrayEquals(expected, actual);
    }


    //EPIC

    @Test
    public void shouldSeachEpicByQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        ToDos todos = new ToDos();
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSeachEpicByGettingSub() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        ToDos todos = new ToDos();
        todos.add(epic);

        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoSeachSubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        ToDos todos = new ToDos();
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("Орехи");
        Assertions.assertArrayEquals(expected, actual);
    }


    //MEETING
    @Test
    public void shouldSeachMeetingQueryProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSeachMeetingQueryTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSeachMeetingByGettingStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();
        todos.add(meeting);

        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSeachMeetingByGettingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();
        todos.add(meeting);

        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSeachMeetingByGettingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();
        todos.add(meeting);

        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNoSeachMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Проверка");
        Assertions.assertArrayEquals(expected, actual);
    }
}
