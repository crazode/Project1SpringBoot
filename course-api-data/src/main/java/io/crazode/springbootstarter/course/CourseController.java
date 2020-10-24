package io.crazode.springbootstarter.course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.crazode.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@PostMapping(value = "/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, " ", " "));
		courseService.addCourse(course);
	}

	@PutMapping(value = "/topics/{topicId}/courses/{id}")
	public void updateTopic(@PathVariable String id, Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, " ", " "));
		courseService.updateCourse(course);
	}

	@DeleteMapping(value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

//	public static void main(String[] args) {
//		Optional<Integer> maybeIntVal = Optional.of(-5);
////		Optional<Integer> maybeIntVal = Optional.empty();
//
//		if (maybeIntVal.isPresent()) {
//			System.out.println(maybeIntVal.get());
//		}
//
//		System.out.println(maybeIntVal
//				.map(val -> val + 5)
//				.filter(val -> val > 2)
//				.map(val -> val - 1));
//	}
}
