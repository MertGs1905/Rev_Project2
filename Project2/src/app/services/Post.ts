import { IUser } from './User';
import { IRating } from './Rating';

export interface IPost {
    postId?: number;
    user: IUser;
    post: string;
    rating: IRating;
}
