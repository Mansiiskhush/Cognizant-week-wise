import React from "react";
import Post from "./Post";

export default class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
    };
  }

  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => this.setState({ posts: data }))
      .catch((error) => {
        console.error("Error fetching posts:", error);
        this.setState({ hasError: true });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred in the component.");
    console.error("Caught error:", error, info);
  }

  render() {
    const { posts, hasError } = this.state;

    if (hasError) {
      return <h1>Something went wrong while loading posts.</h1>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {posts.slice(0, 10).map((post) => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}
