document.addEventListener('DOMContentLoaded', () => {
    const taskInput = document.getElementById('taskInput');
    const addTaskButton = document.getElementById('addTaskButton');
    const deleteAllButton = document.getElementById('deleteAllButton');
    const taskList = document.getElementById('taskList');

    addTaskButton.onclick = () => {
        const taskText = taskInput.value.trim();
        if (taskText) {
            const listItem = document.createElement('li');
            listItem.className = 'task-item';

            const checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.onchange = () => listItem.classList.toggle('completed', checkbox.checked);

            const taskLabel = document.createElement('span');
            taskLabel.textContent = taskText;

            const deleteButton = document.createElement('button');
            deleteButton.className = 'delete-button';
            deleteButton.textContent = 'Delete';
            deleteButton.onclick = () => listItem.remove();

            listItem.append(checkbox, taskLabel, deleteButton);
            taskList.appendChild(listItem);

            taskInput.value = '';
        }
    };

    deleteAllButton.onclick = () => taskList.innerHTML = '';
});
