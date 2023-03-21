const authService = {
    async login(user) {
      const response = await fetch('http://localhost:9000/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(user),
      });
      if (response.ok) {
        return response.json();
      } else {
        throw new Error('Login failed');
      }
    },
  
    async register(user) {
      const response = await fetch('/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(user),
      });
      if (response.ok) {
        return response.json();
      } else {
        throw new Error('Registration failed');
      }
    }
  };
  
  export default authService;